package com.example.feature_login.presentation.ui.screens.register_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.extensions.isValidPassword
import com.example.core_compose.elements.PasswordOutlinedTextField
import com.example.core_compose.elements.ShopOutlinedTextField
import com.example.core_compose.elements.TextTitleBigUI
import com.example.core_compose.elements.YellowButton
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.feature_user_data.model.UserModel


@Composable
internal fun RegisterRoute(
    viewModel: RegisterViewModel = viewModel(),
    navigateToHomeScreen: () -> Unit = {}
) {
    RegisterScreen(
        viewModel = viewModel,
        navigateToHomeScreen = navigateToHomeScreen
    )
}
@Preview
@Composable
internal fun RegisterScreen(
    viewModel: RegisterViewModel = viewModel(),
    navigateToHomeScreen: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
    ) {
        var login by remember {
            mutableStateOf(TextFieldValue(""))
        }
        var name by remember {
            mutableStateOf(TextFieldValue(""))
        }
        var inputTextPassword by remember {
            mutableStateOf(TextFieldValue(""))
        }
        var inputTextRepeatPassword by remember {
            mutableStateOf(TextFieldValue(""))
        }
        var errorTextNewPassword by remember { mutableStateOf("") }
        val errorTextRepeatPassword by remember { mutableStateOf("") }

        val initialText = "Enter password"

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 120.dp)
        ) {
            TextTitleBigUI(
                text = "Register"
            )

            Spacer(modifier = Modifier.height(24.dp))

            ShopOutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                },
                labelText = "Email",
                modifier = Modifier.fillMaxWidth(),
                placeholderText = "Enter your name here"
            )

            Spacer(modifier = Modifier.height(20.dp))

            ShopOutlinedTextField(
                value = login,
                onValueChange = {
                    login = it
                },
                labelText = "Email",
                modifier = Modifier.fillMaxWidth(),
                placeholderText = "Enter your email here"
            )

            Spacer(modifier = Modifier.height(20.dp))

            PasswordOutlinedTextField(
                value = inputTextPassword,
                onValueChange = {
                    inputTextPassword = it
                    errorTextNewPassword = if (!it.text.isValidPassword()) {
                        "Use at least 8 characters, one letter, one digit"
                    } else
                        ""
                },
                labelText = "Enter password",
                modifier = Modifier.fillMaxWidth(),
                placeholderText = initialText,
                errorText = errorTextNewPassword.ifEmpty { null },
            )

            Spacer(modifier = Modifier.height(20.dp))

            PasswordOutlinedTextField(
                value = inputTextRepeatPassword,
                onValueChange = {
                    inputTextRepeatPassword = it
                },
                labelText = "Repeat password",
                modifier = Modifier.fillMaxWidth(),
                placeholderText = initialText,
                errorText = errorTextRepeatPassword.ifBlank { null }
            )
        }

        YellowButton(
            text = "Register",
            onClick = {
                viewModel.registerUser(
                    user = UserModel(
                        login.text,
                        inputTextPassword.text,
                        name.text
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .align(Alignment.BottomCenter)
        )
    }
}