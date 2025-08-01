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

ll func(ll i, ll prevColor, ll k, vector<vector<ll>> &paintCost, vector<ll> &trees, ll n, ll m) {
    if(i == n) {
        cout << i << " " << prevColor << " " << k << ln;
        if(k == 1) return 0;
        return 1e5;
    }
    if(k <= 0) return 1e5;

    if(trees[i] != 0) return func(i + 1, trees[i], (trees[i] == prevColor || i == 0) ? k : k - 1, paintCost, trees, n, m);

    ll minCost = 1e5;
    for(int j = 1; j <= m; j++) {
        ll cost = paintCost[i][j] + func(i + 1, j, (j == prevColor || i == 0) ? k : k - 1, paintCost, trees, n, m);
        minCost = min(minCost, cost);
    }

    cout << i << " " << prevColor << " " << k << " " << minCost << ln;

    return minCost;
}

void solve() {

    ll n, m, k;
    cin >> n >> m >> k;

    vector<ll> trees(n);
    for(int i = 0; i < n; i++) cin >> trees[i];

    vector<vector<ll>> paintCost(n, vector<ll>(m));
    for(int i = 0; i < n; i++)
        for(int j = 0; j < m; j++)
            cin >> paintCost[i][j];

    cout << func(0, -1, k, paintCost, trees, n, m) << ln;
   
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