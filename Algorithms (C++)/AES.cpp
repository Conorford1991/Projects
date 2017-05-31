/*
Author: Conor Ford
AES class
*/

#include "stdafx.h"
// cryptlib.h provides basic abstractions for the Crypto++ library. 
#include "..\Crypto++\cryptlib.h"
// Crypto++ exposes most AES encrpytion and decryption operations through aes.h.
#include "..\Crypto++\aes.h"
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

// Namespaces
using namespace std;
using namespace CryptoPP;

string AESEncrypt(string plaintext, SecByteBlock key, byte IV[AES::BLOCKSIZE]) {
     string ciphertext, encoded;


	// Encrypt using CFB mode(Cipher Feedback Block)/AES, taking the key, keysize and initial vector as references
	CFB_Mode<AES>::Encryption encrypt(key, key.size(), IV);
	// Encryption using pipelining
	// StringSource is a source for character arrays and strings, true value indicates if the StringSource should pump all of the data immediately to its attached transformation.
	StringSource(plaintext, true,
		// Tranform the encrypted data into characters using pipelining also add padding if required
		new StreamTransformationFilter(encrypt,
			/* StringSink serves as a destination for string data. The StringSink takes a reference to a string.
			Because a reference is taken, the StringSink does not own output, and therefore will not destroy output.*/
			new StringSink(ciphertext)
		)
	);

	// Print using pipelining
	// StringSource is a source for character arrays and strings, true value indicates if the StringSource should pump all of the data immediately to its attached transformation.
	StringSource(ciphertext, true,
		// The HexEncoder encodes bytes into base 16 encoded data, making it easier to display
		new HexEncoder(
			/* StringSink serves as a destination for string data. The StringSink takes a reference to a string.
			Because a reference is taken, the StringSink does not own output, and therefore will not destroy the output.*/
			new StringSink(encoded)
		)
	);

	// Write ciphertext to file
	EncryptedFileWriter(encoded, "AES");

	// Print
	cout << "AES encryption complete. Ciphertext write to file complete" << endl;

	return ciphertext;

}
void AESDecrypt(string ciphertext, SecByteBlock key, byte IV[AES::BLOCKSIZE]) {
	string plaintext;

	// Decrypt using CFB mode(Cipher Block Chaining)/AES, taking the key, keysize and initial vector as references
	CFB_Mode<AES>::Decryption decrypt(key, key.size(), IV);
	//StringSource is a source for character arrays and strings, true value indicates if the StringSource should pump all of the data immediately to its attached transformation.
	StringSource(ciphertext, true,
		// Tranform the encrypted data into characters and also add padding if required
		new StreamTransformationFilter(decrypt,
			/* StringSink serves as a destination for string data. The StringSink takes a reference to a string.
			Because a reference is taken, the StringSink does not own output, and therefore will not destroy output.*/
			new StringSink(plaintext)
		)
	);

	// Write plaintext to file
	DecryptedFileWriter(plaintext, "AES");

	// Print
	cout << "AES decryption complete. Plaintext write to file complete" << endl;
}



