#!/bin/bash

BASEDIR=$(pwd)

#rm -rf ~/.m2/

cd $BASEDIR/pitest-pitest-parent-1.1.7/pitest/
mvn install -Dmaven.test.skip=true

#cd ../pitest-maven/
#mvn clean install -Dmaven.test.skip=true

cd $BASEDIR/commons-math3-3.5-src/
mvn org.pitest:pitest-maven:mutationCoverage
