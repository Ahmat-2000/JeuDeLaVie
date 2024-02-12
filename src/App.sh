#!/bin/bash

javac -d ../build model/*.java model/observer/*.java view/*.java Main.java && java -cp ../build Main
