terraform {
  backend "local" {
    path = "/var/lib/jenkins/workspace/Terraform-Pipeline/terraform.tfstate"
  }
}

provider "aws" {
  region     = "eu-north-1"
  access_key = "AKIA4MTWJGD54DCDIZ6J"    # Use environment variables or AWS credentials instead of hardcoding
  secret_key = "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" # Same as above
}

resource "aws_vpc" "main" {
  cidr_block = "10.0.0.0/16"

  tags = {
    Name = "main-vpc"
  }
}

