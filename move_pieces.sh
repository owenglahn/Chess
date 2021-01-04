#!/bin/bash

if [[ $# != 3 ]] 
then 
	echo "Error: format: ./move_pieces.sh file desired name"
	exit 1
fi

mv $1 "C:/Users/Owen/OneDrive/Documents/PersonalProjects/Chess/resources/$2"
