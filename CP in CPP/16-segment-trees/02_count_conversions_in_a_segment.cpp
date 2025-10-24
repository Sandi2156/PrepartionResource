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

class Node {
    private:
        int count = 0;
        vector<int> freq;
    public:
        Node() {
            freq.resize(41, 0);
        }

        int getCount() {
            return count;
        }

        void setCount(int count) {
            this->count = count;
        }

        void incr(int num) {
            freq[num]++;
        }

        void decr(int num) {
            freq[num]--;
        }

        vector<int> getFreqArr() {
            return freq;
        }

        void updateFreq(vector<int> &arr, int i, int j) {
            for(int i = 0; i <= 40; i++) freq[i] = 0;
            while(i <= j) {
                freq[arr[i]]++;
                i++;
            }
        }
};

class SegmentTree {
    private:
        int arrLen, segLen;
        vector<int> arr;
        vector<Node*> seg;

        int getLeftChildIndex(int idx) {
            2 * idx;
        }

        int getRightChildIndex(int idx) {
            return 2 * idx + 1;
        }

        int getCountInversions(vector<int> freq1, vector<int> freq2) {
            int count = 0;
            for(int i = 0; i <= 40; i++) {
                for(int j = i-1; j >= 0; j--) {
                    if(freq2[j] != 0) count += freq1[i];
                }
            }

            return count;
        }

    public:
        SegmentTree(int n, vector<int> arr) {
            arrLen = n;
            segLen = 4 * n;
            this->arr = arr;
            seg.resize(segLen);

            build(0, arrLen-1, 1);
        }

        void build(int s, int e, int nodeIdx) {
            if(s == e) {
                seg[nodeIdx] = new Node();
                seg[nodeIdx]->incr(arr[s]);
                return;
            }

            int mid = (s + e) / 2;
            build(s, mid, getLeftChildIndex(nodeIdx));
            build(mid+1, e, getRightChildIndex(nodeIdx));

            seg[nodeIdx] = new Node();
            
            int mergeCount = getCountInversions(seg[getLeftChildIndex(nodeIdx)]->getFreqArr(), seg[getRightChildIndex(nodeIdx)]->getFreqArr());
            seg[nodeIdx]->setCount(seg[getLeftChildIndex(nodeIdx)]->getCount() + seg[getRightChildIndex(nodeIdx)]->getCount() + mergeCount);

            seg[nodeIdx]->updateFreq(arr, s, e);      
        }


        void update(int s, int e, int nodeIdx, int updatedIdx, int updatedVal) {
            if(s == e) {
                seg[nodeIdx]->decr(arr[s]);
                arr[s] = updatedVal;
                seg[nodeIdx]->incr(arr[s]);
                return;
            }

            int mid = (s + e) / 2;
            if(updatedIdx <= mid) update(s, mid, getLeftChildIndex(nodeIdx), updatedIdx, updatedVal);
            else update(mid+1, e, getRightChildIndex(nodeIdx), updatedIdx, updatedVal);
            
            int mergeCount = getCountInversions(seg[getLeftChildIndex(nodeIdx)]->getFreqArr(), seg[getRightChildIndex(nodeIdx)]->getFreqArr());
            seg[nodeIdx]->setCount(seg[getLeftChildIndex(nodeIdx)]->getCount() + seg[getRightChildIndex(nodeIdx)]->getCount() + mergeCount);

            seg[nodeIdx]->updateFreq(arr, s, e);      
        }


        int query(int s, int e, int nodeIdx, int l, int r) {
            
            if(r < s || l > e) return 0;

            if(s >= l && e <= r) return seg[nodeIdx]->getCount();

            int mid = (s + e) / 2;
            return query(s, mid, getLeftChildIndex(nodeIdx), l, r) + query(mid+1, e, getRightChildIndex(nodeIdx), l, r); 
        }


};


void solve() {
   ll t = 1;
   cin>>t;
   while(t--) {
       
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