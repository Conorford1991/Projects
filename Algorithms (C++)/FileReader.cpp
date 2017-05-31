/*
Author: Conor Ford
FileReader class
*/

#include "stdafx.h"
// Input/output stream
#include <iostream>
// Stream class to both read and write from/to files.
#include <fstream>
// String class
#include <string>

// Namespaces
using namespace std;

string FileReader(string File) {
	string line;

	// read file
	ifstream file(File);

	// if file is open
	if (file.is_open())
	{
		// while line is still being received from file
		while (getline(file, line))
		{
			// return the line
			return line;
		}
		// close the file
		file.close();
	}

	else cout << "Unable to open file";

}

string KeyReader() {
	string line;

	// read file
	ifstream file("C:\\Users\\Conor\\Desktop\\Computer Science\\Project\\AESkey.txt");

	// if file is open
	if (file.is_open())
	{
		// while line is still being received from file
		while (getline(file, line))
		{
			// return the line
			return line;
		}
		// close the file
		file.close();
	}

	else cout << "Unable to open file";

}
// write ciphertext to file
void EncryptedFileWriter(string text, string AlgoType){
	ofstream myfile("C:\\Users\\Conor\\Desktop\\Project Demo\\Encrypted Files\\ " + AlgoType + " (C++).txt");

	if (myfile.is_open())
	{
		myfile << text;
		myfile.close();
	}
	else cout << "Unable to open file";
}
// write plaintext to file
void DecryptedFileWriter(string text, string AlgoType){
	ofstream myfile("C:\\Users\\Conor\\Desktop\\Project Demo\\Decrypted Files\\ " + AlgoType + " (C++).txt");

	if (myfile.is_open())
	{
		myfile << text;
		myfile.close();
	}
	else cout << "Unable to open file";
}
