#!/bin/bash

BASEDIR=$(pwd)

./clean.sh

cd $BASEDIR/pitest-pitest-parent-1.1.7/pitest/
mvn install -Dmaven.test.skip=true

cd $BASEDIR/commons-math3-3.5-src/
mvn compile
mvn org.pitest:pitest-maven:mutationCoverage
