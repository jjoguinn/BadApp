#!/bin/sh

curl -H -X POST -d @TestReq.json localhost:8080/storeForMemLeak

curl -H 'multipart/form-data' -X POST -F "file=@ursa.dat.safe" localhost:8080/

