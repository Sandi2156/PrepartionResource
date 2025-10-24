#include <bits/stdc++.h>  // This will work only for g++ compiler.

#define for0(i, n) for (int i = 0; i < (int)(n); ++i) // 0 based indexing
#define for1(i, n) for (int i = 1; i <= (int)(n); ++i) // 1 based indexing
#define forc(i, l, r) for (int i = (int)(l); i <= (int)(r); ++i) // closed interver from l to r r inclusive
#define forr0(i, n) for (int i = (int)(n) - 1; i >= 0; --i) // reverse 0 based.
#define forr1(i, n) for (int i = (int)(n); i >= 1; --i) // reverse 1 based

// short hand for usual tokens
#define pb push_back
#define fi first
#define se second
#define ln "\n"

// to be used with algorithms that processes a container Eg: find(all(c),42)
#define all(x) (x).begin(), (x).end() // Forward traversal
#define rall(x) (x).rbegin, (x).rend() // Reverse traversal

// traversal function to avoid long template definition. Now with C++11 auto alleviates the pain.
#define tr(c,i) for(__typeof__((c)).begin() i = (c).begin(); i != (c).end(); i++)

// find if a given value is present in a container. Container version. Runs in log(n) for set and map
#define present(c,x) ((c).find(x) != (c).end())

// find version works for all containers. This is present in std namespace.
#define cpresent(c,x) (find(all(c),x) != (c).end())

// Avoiding wrap around of size()-1 where size is a unsigned int.
#define sz(a) int((a).size())


using namespace std;

// Shorthand for commonly used types
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef pair<int, int> ii;
typedef vector<ii> vii;
typedef long long ll;
typedef vector<ll> vll;
typedef vector<vll> vvll;
typedef double ld;

class SegTree {
    private:
        ll n;
        vector<ll> arr;
        vector<ll> seg;
    
        ll getLeftChildIndex(ll i) {
            return 2 * i;
        }
    
        ll getRightChildIndex(ll i) {
            return 2 * i + 1;
        }

        void build(ll nodeIdx, ll i, ll j, vector<ll> &arr, vector<ll> &seg) {
            if(i == j) {
                seg[nodeIdx] = arr[i];
                return;
            }
    
            ll mid = (i + j) / 2;
            build(getLeftChildIndex(nodeIdx), i, mid, arr, seg);
            build(getRightChildIndex(nodeIdx), mid+1, j, arr, seg);
            
            seg[nodeIdx] = min(seg[getLeftChildIndex(nodeIdx)], seg[getRightChildIndex(nodeIdx)]);
        }

        void update(ll nodeIdx, ll i, ll j, ll k, ll u, vector<ll> &seg) {
            if(i == j) {
                seg[nodeIdx] = u;
                return;
            }
    
            ll mid = (i + j) / 2;
            if(k <= mid) update(getLeftChildIndex(nodeIdx), i, mid, k, u, seg);
            else update(getRightChildIndex(nodeIdx), mid+1, j, k, u, seg);
    
            seg[nodeIdx] = min(seg[getLeftChildIndex(nodeIdx)], seg[getRightChildIndex(nodeIdx)]);
        }

        ll query(ll nodeIdx, ll i, ll j, ll u, ll v, vector<ll> &seg) {
            if(v < i || u > j) return INT_MAX;
    
            if(i >= u && j <= v) return seg[nodeIdx];
    
            ll mid = (i + j) / 2;
            return min(query(getLeftChildIndex(nodeIdx), i, mid, u, v, seg), query(getRightChildIndex(nodeIdx), mid+1, j, u, v, seg));
        }
    public:
        SegTree(ll n, vector<ll> arr) {
            this->n = n;
            this->arr = arr;
            seg.resize(4*n);

            build(1, 0, n-1, arr, seg);
        }

        void updateIdx(ll k, ll u) {
            update(1, 0, n-1, k, u, seg);
        }

        ll queryRange(ll u, ll v) {
            return query(1, 0, n-1, u, v, seg);
        }
};

void solve() {
   ll t = 1;
   // cin>>t;
   while(t--) {
       ll n, q;
       cin >> n >> q;

       vector<ll> arr(n);
       for(int i = 0; i < n; i++) cin >> arr[i];

       SegTree segTree(n, arr);

       while(q--) {
        int type;
        cin >> type;

        if(type == 1) {
            ll k, u;
            cin >> k >> u;

            segTree.updateIdx(k-1, u);
        } else {
            ll a, b;
            cin >> a >> b;

            cout << segTree.queryRange(a-1, b-1) << ln;
        }
       }
   }
   //TC: O()
   //SC: O()
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.precision(10);
    cout << fixed;
    solve();
    return 0;
}