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

class SegmentTree {
    private:
        int n, segLen;
        string str;
        vector<map<char, int>> seg;

        int getLeftChildIndex(int idx) {
            return 2 * idx;
        }

        int getRightChildIndex(int idx) {
            return 2 * idx + 1;
        }
    
    public:
        SegmentTree(string s) {
            str = s;
            n = s.length();
            segLen = 4 * n;
            seg.resize(segLen);

            build(0, n-1, 1);
        }

        char getChar(int idx) {
            return str[idx];
        }

        void build(int s, int e, int nodeIdx) {
            if(s == e) {
                seg[nodeIdx][str[s]]++;
                return;
            }

            int mid = (s + e) / 2;
            build(s, mid, getLeftChildIndex(nodeIdx));
            build(mid+1, e, getRightChildIndex(nodeIdx));

            for(auto it: seg[getLeftChildIndex(nodeIdx)])
                seg[nodeIdx][it.first] += it.second;
            for(auto it: seg[getRightChildIndex(nodeIdx)])
                seg[nodeIdx][it.first] += it.second;
        }

        void update(int s, int e, int nodeIdx, int updatedIdx, char updatedChar, char curChar) {
            if(s == e) {
                seg[nodeIdx].clear();
                seg[nodeIdx][updatedChar]++;
                str[updatedIdx] = updatedChar;
                return;
            }

            int mid = (s + e) / 2;
            if(updatedIdx <= mid) update(s, mid, getLeftChildIndex(nodeIdx), updatedIdx, updatedChar, curChar);
            else update(mid+1, e, getRightChildIndex(nodeIdx), updatedIdx, updatedChar, curChar);

            seg[nodeIdx][curChar]--;
            if(seg[nodeIdx][curChar] == 0) seg[nodeIdx].erase(curChar);
            seg[nodeIdx][updatedChar]++;
        }

        void query(int s, int e, int nodeIdx, int l, int r, set<char> &distinctSet) {
            if(r < s || l > e) return;

            if(s >= l && e <= r) {
                for(auto it: seg[nodeIdx]) {
                    distinctSet.insert(it.first);
                }
                return;
            }

            int mid = (s + e) / 2;
            query(s, mid, getLeftChildIndex(nodeIdx), l, r, distinctSet);
            query(mid+1, e, getRightChildIndex(nodeIdx), l, r, distinctSet);
        }
};


void solve() {
   ll t = 1;
//    cin>>t;
   while(t--) {
       string s;
       cin >> s;

       SegmentTree segmentTree(s);

       int q;
       cin >> q;

       while(q--) {
            int type;
            cin >> type;

            if(type == 1) {
                int pos;
                char c;
                cin >> pos;
                cin >> c;

                segmentTree.update(0, s.length()-1, 1, pos-1, c, segmentTree.getChar(pos-1));

            } else if(type == 2) {
                int l, r;
                cin >> l >> r;

                set<char> distinctSet;
                segmentTree.query(0, s.length()-1, 1, l-1, r-1, distinctSet);
                cout << distinctSet.size() << ln;
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