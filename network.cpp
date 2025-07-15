#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

bool isReachable(const string &ip) {
    string cmd = "ping -c 1 -W 1 " + ip + " > /dev/null 2>&1";
    return system(cmd.c_str()) == 0;
}

int main(int argc, char* argv[]) {
    if (argc != 2) {
        cout << "Usage: " << argv[0] << " <base-ip> (e.g., 192.168.1)\n";
        return 1;
    }

    string baseIP = argv[1];

    cout << "Scanning " << baseIP << ".1 to " << baseIP << ".254...\n";

    for (int i = 1; i <= 254; ++i) {
        string ip = baseIP + "." + to_string(i);
        if (isReachable(ip)) {
            cout << "Device found at: " << ip << endl;
        }
    }

    return 0;
}
