
resource "azurerm_resource_group" "aks_rg" {
  name     = "myAKSRegion"
  location = "westus2"
}

resource "azurerm_kubernetes_cluster" "aks_cluster" {
  name                = "myAKSCluster"
  location            = azurerm_resource_group.aks_rg.location
  resource_group_name = azurerm_resource_group.aks_rg.name
  dns_prefix          = "yan-test"

  default_node_pool {
    enable_auto_scaling = false
    name       = "yan-node-poll"
    node_count = 1
    vm_size    = "Standard_B2s"
  }

  service_principal {
    client_id     = "YOUR_AZURE_CLIENT_ID"
    client_secret = "YOUR_AZURE_CLIENT_SECRET"
  }

  network_profile {
    network_plugin = "azure"
  }
}