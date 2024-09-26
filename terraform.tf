provider "aws" {
  region = "eu-north-1"
}

# Create a VPC resource
resource "aws_vpc" "main" {
  cidr_block = "10.0.0.0/16"

  tags = {
    Name = "main"
  }
}