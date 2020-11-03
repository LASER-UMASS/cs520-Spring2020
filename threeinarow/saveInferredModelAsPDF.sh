#!/bin/bash

echo "Converting file $1 to PDF...";
dot $1 -Tpdf -o `dirname $1`/`basename $1 .dot`".pdf"
