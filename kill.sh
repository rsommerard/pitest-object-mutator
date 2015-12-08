#!/bin/bash

BASEDIR=$(pwd)

cd $BASEDIR/pitest-pitest-parent-1.1.7/pitest/
mvn clean

cd $BASEDIR/kill-the-mutants/
mvn clean

#cd $BASEDIR/pitest-pitest-parent-1.1.7/pitest/
#mvn install -Dmaven.test.skip=true

cd $BASEDIR/kill-the-mutants/
mvn compile
mvn org.pitest:pitest-maven:mutationCoverage
