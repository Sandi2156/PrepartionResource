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

/*
    1 2 3 4 5 6 7 8
    a   b  c  d

    1 0 0
    1 0 1

*/

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

        bool build(ll nodeIdx, ll i, ll j, vector<ll> &arr, vector<ll> &seg) {
            if(i == j) {
                seg[nodeIdx] = arr[i];
                return true;
            }
    
            ll mid = (i + j) / 2;
            bool a = build(getLeftChildIndex(nodeIdx), i, mid, arr, seg);
            bool b = build(getRightChildIndex(nodeIdx), mid+1, j, arr, seg);
            
            seg[nodeIdx] = (a && b) ? (seg[getLeftChildIndex(nodeIdx)] | seg[getRightChildIndex(nodeIdx)]) : (seg[getLeftChildIndex(nodeIdx)] ^ seg[getRightChildIndex(nodeIdx)]);
            return !(a & b);
        }

        bool update(ll nodeIdx, ll i, ll j, ll k, ll u, vector<ll> &seg) {
            if(i == j) {
                seg[nodeIdx] = u;
                // cout << i << " " << j << " " << seg[nodeIdx] << ln;
                return true; 
            }
    
            ll mid = (i + j) / 2;
            bool a = false;
            if(k <= mid) a = update(getLeftChildIndex(nodeIdx), i, mid, k, u, seg);
            else a = update(getRightChildIndex(nodeIdx), mid+1, j, k, u, seg);
    
            seg[nodeIdx] = a ? seg[getLeftChildIndex(nodeIdx)] | seg[getRightChildIndex(nodeIdx)] : seg[getLeftChildIndex(nodeIdx)] ^ seg[getRightChildIndex(nodeIdx)];
            // cout << i << " " << j << " " << seg[nodeIdx] << ln;
            return !a;
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

        ll getVal() {
            return seg[1];
        }
};

void solve() {
   ll t = 1;
   // cin>>t;
   while(t--) {
       ll n, m;
       cin >> n >> m;

       vector<ll> arr(1 << n);
       for(int i = 0; i < (1 << n); i++) {
        cin >> arr[i];
       }

       SegTree segTree((1 << n), arr);

       while(m--) {
        ll p, b;
        cin >> p >> b;

        segTree.updateIdx(p-1, b);
        cout << segTree.getVal() << ln;
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