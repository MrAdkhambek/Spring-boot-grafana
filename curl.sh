#!/bin/bash

for i in {1..500}; 
do {
    curl http://localhost:8080/api/v1/male; 
};
done