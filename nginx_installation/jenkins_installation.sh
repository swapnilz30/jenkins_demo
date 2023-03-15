#!/usr/bin/env bash
curl -fsSL https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo tee /usr/share/keyrings/jenkins-keyring.asc > /dev/null

echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/  | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null

sudo apt update

sudo apt install openjdk-11-jdk -y

sudo apt install jenkins -y

sudo systemctl status jenkins

sudo systemctl enable --now jenkins

ip=$(hostname -I)

echo "Open the following URL in browser \nhttp://$ip:8080 or http://localhost:8080"