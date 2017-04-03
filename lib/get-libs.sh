#!/bin/bash 

# Autor: Adam Novak
# FIT VUT Brno 
# Skript stiahne pozadovane obrazky zo serveru

if ! [ -d "./lib/image" ]
then
	# Downloading from www.stud.fit.vutbr.cz/~xnovak1b/image.zip
	wget -O image.zip "www.stud.fit.vutbr.cz/~xnovak1b/image.zip"
	# Create dir for image	
	mkdir ./lib/image
	mkdir ./build/lib
	mkdir ./build/lib/image
	# Unzip file
	unzip image.zip -d ./lib/image
	unzip image.zip -d ./build/lib/image
	# Deleting zip file
	rm image.zip
fi
