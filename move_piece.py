from os import *
from shutil import *
from sys import *

try:
    rename(argv[1], "C:/Users/Owen/OneDrive/Documents/PersonalProjects/Chess/resources/" + argv[2])
except FileExistsError as e:
    remove("C:/Users/Owen/OneDrive/Documents/PersonalProjects/Chess/resources/" + argv[2])
    rename(argv[1], "C:/Users/Owen/OneDrive/Documents/PersonalProjects/Chess/resources/" + argv[2])
