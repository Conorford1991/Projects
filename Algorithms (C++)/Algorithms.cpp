/*
Author: Conor Ford
Main file of application
*/

// Header
#include "stdafx.h"
// cryptlib.h provides basic abstractions for the Crypto++ library. 
#include "..\Crypto++\cryptlib.h"
// Crypto++ exposes most RSA encrpytion and decryption operations through aes.h.
#include "..\Crypto++\aes.h"
// Crypto++ exposes most DES encryption and decryption operations through des.h.
#include "..\Crypto++\des.h"
// AutoSeededRandomPool
#include "..\Crypto++\osrng.h"
// Input/output stream
#include <iostream>
// Stream class to both read and write from/to files.
#include <fstream>
// String class
#include <string>
// Cipher mode CBC, ECB etc.
#include "..\Crypto++\modes.h"
// The HexEncoder encodes bytes into base 16 encoded data, making it easier to display
#include "..\Crypto++\hex.h"


// namespaces
using namespace std;
using namespace CryptoPP;

void AES_call(string DataSizeSelect) {
	// Instantiate AutoSeededRandomPool
	AutoSeededRandomPool rand;

	// AES MAX_KEYLENGTH = 32 bytes (256 bits)
	// AES MIN_KEYLENGTH = 24 bytes (192 bits)
	// AES DEFAULT_KEYLENGTH = 16 bytes (128 bits)
	SecByteBlock key(AES::MAX_KEYLENGTH);

	// Generate random Initial Vector (IV) based on the AES blocksize
	byte IV[AES::BLOCKSIZE];

	// Generate block based on the initial vector and the AES blocksize
	rand.GenerateBlock(IV, AES::BLOCKSIZE);

	// Plaintext string takes value of the FileReader method,
	// which has the data size input
	string plaintext = FileReader(DataSizeSelect);

	// Start timer (Encryption)
	clock_t Encryptstart = clock();

	// Encrypt
	string ciphertext = AESEncrypt(plaintext, key, IV);
	
	// End timer (Encryption)
	clock_t Encryptend = clock();

	// Time elapsed calculation (Encryption)
	double elapsed_secs = double(Encryptend - Encryptstart) / CLOCKS_PER_SEC;

	// Start timer (Decryption)
	clock_t Decryptstart = clock();

	// Decrypt
	AESDecrypt(ciphertext, key, IV);

	// End timer (Decryption)
	clock_t Decryptend = clock();

	// Time elapsed calculation (Decryption)
	double elapsed_secs2 = double(Decryptend - Decryptstart) / CLOCKS_PER_SEC;

	// Print
	cout << "AES Time to encrypt: " << elapsed_secs << endl;
	cout << "AES Time to decrypt: " << elapsed_secs2 << endl;
	cout << "-------------------------------------------" << endl;


}

void DES_call(string DataSizeSelect) {
	// Instantiate AutoSeededRandomPool
	AutoSeededRandomPool rand;

	// DES DEFAULT_KEYLENGTH = 8 bytes (64 bits)
	SecByteBlock key(DES::DEFAULT_KEYLENGTH);

	// Generate random Initial Vector (IV) based on the DES blocksize
	byte IV[DES::BLOCKSIZE];

	// Generate block based on the initial vector and the DES blocksize
	rand.GenerateBlock(IV, DES::BLOCKSIZE);

	// Plaintext string takes value of the FileReader method,
	// which has the data size input
	string plaintext = FileReader(DataSizeSelect);

	// Start timer (Encryption)
	clock_t Encryptstart = clock();

	// Encrypt
	string ciphertext = DESEncrypt(plaintext, key, IV);

	// End timer (Ecryption)
	clock_t Encryptend = clock();

	// Time elapsed calculation (Encryption)
	double elapsed_secs = double(Encryptend - Encryptstart) / CLOCKS_PER_SEC;

	// Start timer (Decryption)
	clock_t Decryptstart = clock();

	// Decrypt
	DESDecrypt(ciphertext, key, IV);

	// End timer (Decryption)
	clock_t Decryptend = clock();

	// Time elapsed calculation (Decryption)
	double elapsed_secs2 = double(Decryptend - Decryptstart) / CLOCKS_PER_SEC;

	// Print
	cout << "DES Time to encrypt: " << elapsed_secs << endl;
	cout << "DES Time to decrypt: " << elapsed_secs2 << endl;
	cout << "-------------------------------------------" << endl;

}

void TDES_call(string DataSizeSelect) {
	
	// Instantiate AutoSeededRandomPool
	AutoSeededRandomPool rand;

	// TDES default keylength = 24 bytes (192 bits)
	SecByteBlock key(DES_EDE3::MAX_KEYLENGTH);

	// Generate random Initial Vector (IV) based on the TDES blocksize
	byte IV[DES_EDE3::BLOCKSIZE];

	// Generate block based on the initial vector and the TDES blocksize
	rand.GenerateBlock(IV, DES_EDE3::BLOCKSIZE);

	// Plaintext string takes value of the FileReader method,
	// which has the data size input
	string plaintext = FileReader(DataSizeSelect);

	// Start timer (Encryption)
	clock_t Encryptstart = clock();

	// Encrypt
	string ciphertext = TDESEncrypt(plaintext, key, IV);

	// End timer (Ecryption)
	clock_t Encryptend = clock();

	// Time elapsed calculation (Encryption)
	double elapsed_secs = double(Encryptend - Encryptstart) / CLOCKS_PER_SEC;

	// Start timer (Decryption)
	clock_t Decryptstart = clock();

	// Decrypt
	TDESDecrypt(ciphertext, key, IV);

	// End timer (Decryption)
	clock_t Decryptend = clock();

	// Time elapsed calculation (Decryption)
	double elapsed_secs2 = double(Decryptend - Decryptstart) / CLOCKS_PER_SEC;

	// Print
	cout << "TDES Time to encrypt: " << elapsed_secs << endl;
	cout << "TDES Time to decrypt: " << elapsed_secs2 << endl;
	cout << "-------------------------------------------" << endl;

}

void Blowfish_call(string DataSizeSelect) {
	// Instantiate AutoSeededRandomPool
	AutoSeededRandomPool rand;

	// Blowfish min keylength = 4 bytes 
	// Blowfish default keylength = 16 bytes 
	// Blowfish max keylength = 56 bytes
	SecByteBlock key(Blowfish::MAX_KEYLENGTH);

	// Generate random Initial Vector (IV) based on the Blowfish blocksize
	byte IV[Blowfish::BLOCKSIZE];

	// Generate block based on the initial vector and the Blowfish blocksize
	rand.GenerateBlock(IV, Blowfish::BLOCKSIZE);

	// Plaintext string takes value of the FileReader method,
	// which has the data size input
	string plaintext = FileReader(DataSizeSelect);

	// Start timer (Encryption)
	clock_t Encryptstart = clock();

	// Encrypt
	string ciphertext = BlowfishEncrypt(plaintext, key, IV);

	// End timer (Ecryption)
	clock_t Encryptend = clock();

	// Time elapsed calculation (Encryption)
	double elapsed_secs = double(Encryptend - Encryptstart) / CLOCKS_PER_SEC;

	// Start timer (Decryption)
	clock_t Decryptstart = clock();

	// Decrypt
	BlowfishDecrypt(ciphertext, key, IV);

	// End timer (Decryption)
	clock_t Decryptend = clock();

	// Time elapsed calculation (Decryption)
	double elapsed_secs2 = double(Decryptend - Decryptstart) / CLOCKS_PER_SEC;

	// Print
	cout << "Blowfish Time to encrypt: " << elapsed_secs << endl;
	cout << "Blowfish Time to decrypt: " << elapsed_secs2 << endl;
	cout << "-------------------------------------------" << endl;

}

void RSA_call() {
	clock_t Encryptstart = clock();
	// Instantiate AutoSeededRandomPool
	AutoSeededRandomPool rand;

	// Instantiate RSA function
	InvertibleRSAFunction parameters;

	// Generate parameters
	// RSA add's 11 bytes to the message. So, using a 1024 (128 bytes)-bit key, you'll have 117 bytes available for the message. 
	// Therefore RSA isn't usually used to encrypt messages, it's mostly used to encrypt symmetric keys used to encrypt messages.
	parameters.GenerateRandomWithKeySize(rand, 3072);


	// Get & Print Generated Parameters
	// Modulus (message size must be smaller than the modulus size)
	const Integer n = parameters.GetModulus();
	// Prime p
	const Integer p = parameters.GetPrime1();
	// Prime q
	const Integer q = parameters.GetPrime2();
	// Private Exponent
	const Integer d = parameters.GetPrivateExponent();
	// Public Exponent
	const Integer e = parameters.GetPublicExponent();

	// Create Private Key
	RSA::PrivateKey privateKey(parameters);

	// Create Public Key
	RSA::PublicKey publicKey(parameters);

	// Get plaintext from file
	string plaintext = KeyReader();


	// Encryption
	// Using the publickey, plaintext and generated keys as parameters
	string ciphertext = RSAEncrypt(publicKey, plaintext, rand);


	clock_t Encryptend = clock();
	double elapsed_secs = double(Encryptend - Encryptstart) / CLOCKS_PER_SEC;


	clock_t Decryptstart = clock();

	// Decryption
	// Using the privatekey, ciphertext and generated keys as parameters
	RSADecrypt(privateKey, ciphertext, rand);

	clock_t Decryptend = clock();
	double elapsed_secs2 = double(Decryptend - Decryptstart) / CLOCKS_PER_SEC;

	// Print
	cout << "RSA Time to encrypt: " << elapsed_secs << endl;
	cout << "RSA Time to decrypt: " << elapsed_secs2 << endl;
	cout << "-------------------------------------------" << endl;

}

void UserInput() {
	string ExecutionSelect;
	cout << "Start or End execution" << endl;

	// get user input
	getline(cin, ExecutionSelect);
	
	while (ExecutionSelect != "End") {

		string AlgorithmSelect;
		cout << "Select Algorithm: AES, Blowfish, TDES, DES, RSA, All (all algorithms)" << endl;
		getline(cin, AlgorithmSelect);

		string DataSizeSelect;
		cout << "Select Data size (MB): Testing (1KB), 20, 40, 60, 80, 100" << endl;
		getline(cin, DataSizeSelect);

		if (DataSizeSelect == "Testing") {
			DataSizeSelect = "C:\\\\Users\\\\Conor\\\\Desktop\\\\Computer Science\\\\Project\\\\Testing.txt";
		}
		else if (DataSizeSelect == "20") {
			DataSizeSelect = "C:\\\\Users\\\\Conor\\\\Desktop\\\\Computer Science\\\\Project\\\\Test 20.txt";
		}
		else if (DataSizeSelect == "40") {
			DataSizeSelect = "C:\\\\Users\\\\Conor\\\\Desktop\\\\Computer Science\\\\Project\\\\Test 40.txt";
		}
		else if (DataSizeSelect == "60") {
			DataSizeSelect = "C:\\\\Users\\\\Conor\\\\Desktop\\\\Computer Science\\\\Project\\\\Test 60.txt";
		}
		else if (DataSizeSelect == "80") {
			DataSizeSelect = "C:\\\\Users\\\\Conor\\\\Desktop\\\\Computer Science\\\\Project\\\\Test 80.txt";
		}
		else if (DataSizeSelect == "100") {
			DataSizeSelect = "C:\\\\Users\\\\Conor\\\\Desktop\\\\Computer Science\\\\Project\\\\Test 100.txt";
		}
		else {
			cout << ("Invalid data input, try again") << endl;
			UserInput();
		}



		if (AlgorithmSelect == "AES") {
			// AES_call method, pass in DataSelectSize
			AES_call(DataSizeSelect);
			// Recursive UserInput
			UserInput();
		}
		else if (AlgorithmSelect == "Blowfish") {
			Blowfish_call(DataSizeSelect);
			UserInput();
		}
		else if (AlgorithmSelect == "TDES") {
			TDES_call(DataSizeSelect);
			UserInput();
		}
		else if (AlgorithmSelect == "DES") {
			DES_call(DataSizeSelect);
			UserInput();
		}
		else if (AlgorithmSelect == "RSA") {
			RSA_call();
			UserInput();
		}
		else if (AlgorithmSelect == "All") {
			AES_call(DataSizeSelect);
			DES_call(DataSizeSelect);
			TDES_call(DataSizeSelect);
			Blowfish_call(DataSizeSelect);
			RSA_call();
			UserInput();
		}
		else {
			cout << "Invalid algorithm input, try again" << endl;
			UserInput();
		}

		break;

	}

	
}

int main(){
	// UserInput call
	UserInput();
    return 0;
}


