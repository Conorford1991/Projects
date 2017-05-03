#include "stdafx.h"
// Input/output stream
#include <iostream>
// Stream class to both read and write from/to files.
#include <fstream>
// String class
#include <string>


using namespace std;

string FileReader() {
	string line;
	// read file
	ifstream file("C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\Testing.txt");
	if (file.is_open())
	{
		while (getline(file, line))
		{
			return line;
		}
		file.close();
	}

	else cout << "Unable to open file";

}
string KeyReader() {
	string line;
	// read file
	ifstream file("C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\AESkey.txt");
	if (file.is_open())
	{
		while (getline(file, line))
		{
			return line;
		}
		file.close();
	}

	else cout << "Unable to open file";

}