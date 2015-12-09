#!/bin/bash

BASEDIR=$(pwd)

cd $BASEDIR/pitest-pitest-parent-1.1.7/
mvn clean install -DskipTests=true

cd $BASEDIR/commons-math3-3.5-src/
mvn clean test org.pitest:pitest-maven:mutationCoverage
