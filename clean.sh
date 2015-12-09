#!/bin/bash

BASEDIR=$(pwd)

cd $BASEDIR/pitest-pitest-parent-1.1.7/
mvn clean

cd $BASEDIR/kill-the-mutants/
mvn clean

cd $BASEDIR/test-mutants/
mvn clean

rm -rf ~/.m2/
