#!/bin/bash

BASEDIR=$(pwd)

cd $BASEDIR/pitest-pitest-parent-1.1.7/
mvn clean install -DskipTests=true

#cd $BASEDIR/kill-the-mutants/
#mvn clean

#cd $BASEDIR/pitest-pitest-parent-1.1.7/pitest/
#mvn install -Dmaven.test.skip=true

cd $BASEDIR/test-mutants/
mvn clean test org.pitest:pitest-maven:mutationCoverage
