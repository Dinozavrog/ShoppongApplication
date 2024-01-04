package com.example.feature_products.presentation.presentation.ui.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.core_compose.elements.RotatingImage
import com.example.core_compose.elements.ShopCard
import com.example.core_compose.elements.TextCaption1
import com.example.core_compose.elements.TextTitleBigUI
import com.example.feature_products.presentation.domain.model.ProductModel

@Composable
internal fun HomeScreenRoute(
    viewModel: HomeScreenViewModel = viewModel(),
    navigateToProfileScreen: () -> Unit = {}
) {
    HomeScreen(
        viewModel = viewModel,
        navigateToProfileScreen = navigateToProfileScreen
    )
}

@Preview
@Composable
internal fun HomeScreen(
    viewModel: HomeScreenViewModel = viewModel(),
    navigateToProfileScreen: () -> Unit = {}
) {
    val loading = viewModel.loading.collectAsState().value
    val products = viewModel.products.collectAsState().value
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(bottom = 120.dp)
    ) {
        TextTitleBigUI(
            text = "Home"
        )
        ProductsList(
            products,
            loading
        )
    }
}

@Composable
fun ProductsList(
    products: List<ProductModel> = emptyList(),
    loading: Boolean = false
) {
    val items = remember { mutableStateOf(products) }
    val isLoading = remember { mutableStateOf(loading) }

    if (isLoading.value) {
        RotatingImage(
            painter = painterResource(id = com.example.core.R.drawable.logo_for_loader),
            modifier = Modifier.size(88.dp)
        )
    }

    else {
        LazyColumn {
            items(items.value) { item ->
                ProductItem(product = item)
            }
        }
    }
}

@Composable
internal fun ProductItem(
    product: ProductModel
) {

    ShopCard(
        shape = RoundedCornerShape(5.dp)
    ) {
        Column {
            Image(
                painter = rememberAsyncImagePainter(
                    model = product.icon
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            TextCaption1(product.name)
        }
    }
}
