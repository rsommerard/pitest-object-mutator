#!/bin/bash

BASEDIR=$(pwd)

cd $BASEDIR/commons-math3-3.5-src/
mvn clean

cd $BASEDIR/pitest-pitest-parent-1.1.7/
mvn clean

cd $BASEDIR/kill-the-mutants/
mvn clean

rm -rf ~/.m2/
