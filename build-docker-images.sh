#!/bin/bash

docker build -t urban-iptable-management-app:latest --file ./urban-iptable-management/docker/Dockerfile .
docker build -t urban-district-management-app:latest --file ./urban-district-management/docker/Dockerfile .
docker build -t urban-traffic-management-app:latest --file ./urban-traffic-management/docker/Dockerfile .
docker build -t urban-gateway-management-app:latest --file ./urban-gateway-management/docker/Dockerfile .
