#!/bin/bash

BASEDIR=$(pwd)

cd $BASEDIR/pitest-pitest-parent-1.1.7/
mvn clean install -DskipTests=true

OUT=$?
if [[ $OUT != 0 ]]; then
  exit 1
fi

#cd $BASEDIR/kill-the-mutants/
#mvn clean

#cd $BASEDIR/pitest-pitest-parent-1.1.7/pitest/
#mvn install -Dmaven.test.skip=true

cd $BASEDIR/joda-time-2.9.1/
mvn clean test org.pitest:pitest-maven:mutationCoverage
