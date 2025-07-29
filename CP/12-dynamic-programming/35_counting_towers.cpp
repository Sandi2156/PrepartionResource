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

ll MOD = 1e9 + 7;

void solve() {

    

    /*
        dp[i][0] => number of ways we can fill up (i -> N) when a horizontal tile is trying to extend
        dp[i][1] => number of ways we can fill up (i -> N) when two vertical tiles  are trying to extend


        dp[i][0] => sum {
            dp[i+1][1] => closed the horizontal one and trying to extend two vertical one
            dp[i+1][0] => closed the horizontal one and trying to extedn another horizontal one
            dp[i+1][0] => didn't close the previous one and trying to extend the same
        }

        dp[i][1] => sum {
            dp[i+1][1] => clsed the left one and extending the right one. so in the left I am starting a new vertical one
            dp[i+1][1] => closed the right one and extending the left one
            dp[i+1][1] => didn't close and extending both
            dp[i+1][0] => closed both and trying to exted horizontal
            dp[i+1][1] => closed both and starting two vertical
        }
    
    */


    ll t;
    cin >> t;

    ll maxN = 1e6 + 1;
    vector<vector<ll>> dp(maxN, vector<ll>(2));
    vector<ll> ans(maxN);

    dp[0][0] = dp[0][1] = 1;
    for(ll i = 1; i < maxN; i++) {
        dp[i][0] = dp[i-1][1] + dp[i-1][0] + dp[i-1][0];
        dp[i][1] = 4LL * dp[i-1][1] + dp[i-1][0];

        dp[i][0] %= MOD;
        dp[i][1] %= MOD;

        ans[i] = (dp[i-1][0] + dp[i-1][1]) % MOD;
    }

    while(t--) {
        ll N;
        cin >> N;

        cout << ans[N] << ln;
    }


   //TC: O(N + T)
   //SC: O(N)
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.precision(10);
    cout << fixed;
    solve();
    return 0;
}