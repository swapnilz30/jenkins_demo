#!/bin/bash

# Define a function to be executed when an error occurs
error_handling() {
    echo "An error occurred during installation. Please check the output for details."
    exit 1
}

# Set the script to exit on any error
set -e

# Trap an error signal to execute the error_handling function
trap error_handling ERR

echo "Starting Jenkins installation..."

# Update the package list
sudo apt update

# Install OpenJDK 17
sudo apt install openjdk-17-jdk -y

# Verify Java installation
java -version

# Add Jenkins repository key
wget -q -O - https://pkg.jenkins.io/debian-stable/jenkins.io.key | sudo apt-key add -

# Add the Jenkins repository
sudo sh -c 'echo deb https://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'

# Add the GPG key for Jenkins
sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 5BA31D57EF5975CA

# Update the package list again after adding Jenkins repository
sudo apt update

# Install Jenkins
sudo apt install jenkins -y

# Check Jenkins status
sudo systemctl status jenkins

# Start Jenkins service
sudo systemctl start jenkins

# Enable Jenkins service to start on boot
sudo systemctl enable jenkins

echo "Jenkins installation and setup completed successfully."
