#!/bin/sh

if [ $# -lt 2 ]
then
    echo "Usage: ${0} [list|store] url [file]"
    exit 1
fi

tranType=${1}
url=${2}

if [ ${tranType} == "store" ]
then
    shift 2

    if [ $# -lt 1 ]
    then
        echo "Tran type 'store' requires a file param"
        exit 1
    fi

    file=${1}

    curl -H 'multipart/form-data' -X POST -F "file=@${file}" ${url}/storeFile
else
    curl ${url}/listFiles
fi

