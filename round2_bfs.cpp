#include <iostream>
#include <vector>
#include <queue>
using namespace std;

// Wir nehmen wieder an, dass E eine nullbasierte Adjazenzliste darstellt.
vector<vector<int> > E;
vector<bool> visited;
vector<int> dist;

void bfs(int start) {
    queue<int> Q; // Die Warteschlange für die neu entdeckten Knoten.
    Q.push(start);
    
    while(!Q.empty()) {
        int v = Q.front();
        Q.pop();
        // Wir sind in Knoten v und erkunden die Nachbarschaft.
        
        for(int e = 0; e < E[v].size(); e++) {
            int w = E[v][e];
            // Nun prüfen wir, ob der Nachbar w noch unbesucht ist.
            if(!visited[w]) {
                visited[w] = true;
                // Anstelle des rekursiven Aufruf der DFS,
                // fügen wir w nun lediglich in die Schlange ein.
                Q.push(w);
                dist[w] = dist[v] + 1; // Neue Zeile!
            }
        }
    }
}

int main() {
    // Graph einlesen, wie zuvor.
    
    int n, m;
    
    //ios_base::sync_with_stdio(false);
    
    cin >> n >> m;
    E = vector<vector<int> >(n);
    for(int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        E[a].push_back(b);
        E[b].push_back(a);
    }
    
    // Nun können wir die Breitensuche starten
    int start = 0;
    
    visited = vector<bool>(n, false); // Zu Beginn haben wir noch nichts besucht.
    visited[start] = true;
    dist = vector<int>(n);
    bfs(start);
    
    // In visited[] können wir nun wiederum ablesen, ob
    // ein bestimmter Knoten erreicht werden kann.
    
    cout << dist[n-1];
}
