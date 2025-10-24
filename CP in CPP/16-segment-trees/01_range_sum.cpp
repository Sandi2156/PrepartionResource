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

int getLeftChildIndex(int idx) {
    return 2 * idx;
}

int getRightChildIndex(int idx) {
    return 2 * idx + 1;
}

void build(vector<int> &sgt, vector<int> &arr, int s, int e, int nodeIdx) { // s, e is the range that current node represent, nodeIdx is where the value is stored
    if(s == e) {
        sgt[nodeIdx] = arr[s];
        return;
    }

    int mid = (s + e) / 2;
    build(sgt, arr, s, mid, getLeftChildIndex(nodeIdx));
    build(sgt, arr, mid+1, e, getRightChildIndex(nodeIdx));

    sgt[nodeIdx] = sgt[getLeftChildIndex(nodeIdx)] + sgt[getRightChildIndex(nodeIdx)];
}

void update(vector<int> &sgt, vector<int> &arr, int s, int e, int nodeIdx, int updateIdx, int updateVal) {
    if(s == e) {
        arr[s] = updateVal;
        sgt[nodeIdx] = updateVal;
        return;
    }

    int mid = (s + e) / 2;
    if(updateIdx <= mid) update(sgt, arr, s, mid, getLeftChildIndex(nodeIdx), updateIdx, updateVal);
    else update(sgt, arr, mid+1, e, getRightChildIndex(nodeIdx), updateIdx, updateVal);

    sgt[nodeIdx] = sgt[getLeftChildIndex(nodeIdx)] + sgt[getRightChildIndex(nodeIdx)];
}

int query(vector<int> &sgt, int s, int e, int nodeIdx, int l, int r) {

    // if out of range
    if(r < s || l > e) return 0;

    // nodeRange is completely under the query range
    if(s >= l && e <= r) return sgt[nodeIdx];

    // partial
    int mid = (s + e) / 2;
    return query(sgt,  s, mid, getLeftChildIndex(nodeIdx), l, r) + query(sgt, mid+1, e, getRightChildIndex(nodeIdx), l, r);
}

void solve() {
   ll t = 1;
//    cin>>t;
   while(t--) {
        int n;
        cin >> n;

        vector<int> arr(n);
        for(int i = 0; i < n; i++) cin >> arr[i];

        // segment tree
        vector<int> sgt(4*n);
        build(sgt, arr, 0, n-1, 1);

        int q;
        cin >> q;
        while(q--) {
            int type;
            cin >> type;

            if(type == 1) { // update
                int idx, val;
                cin >> idx>> val;
                update(sgt, arr, 0, n-1, 1, idx, val);
            } else if(type == 2) { // query
                int l, r;
                cin >> l >> r;
                cout << query(sgt, 0, n-1, 1, l, r) << endl;
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