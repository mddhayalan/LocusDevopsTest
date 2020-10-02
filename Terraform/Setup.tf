provider "azurerm" {
  version = "=1.35.0"
}
resource "azurerm_resource_group" "locusdevops" {
  name     = "locusdevops-resourcegroup"
  location = "central india"
}

resource "azurerm_container_group" "locusdevops" {
  name                = "maven-builder"
  location            = azurerm_resource_group.locusdevops.location
  resource_group_name = azurerm_resource_group.locusdevops.name
  ip_address_type     = "public"
  //dns_name_label      = "aci-label"
  os_type             = "Linux"

  container {
    name   = "mavenbuilder"
    image  = "maven:latest"
    cpu    = "1"
    memory = "1"

    ports {
      port     = 443
      protocol = "TCP"
    }
  }

  tags = {
    environment = "testing"
  }
}