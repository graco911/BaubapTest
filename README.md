# Baubap TEST

Test for baubap candidature postulation.

## Introduction

This test was created to apply for an Android Developer Job in baubap.

## Features
- [X] Clean Architecture
- [x] MVVM
- [x] Kotlin
- [x] Unit Testing

## Screenshots
<img src="https://user-images.githubusercontent.com/4141290/213439072-9a8ea5b6-a847-436a-8609-9e2726d0754f.gif" width=35% height=35%>

## Unit Tests
```kotlin
class MainActivityTests {

    @Test
    fun validateCredentials_AddValidCredentials_SuccessValidation() {
        val email = "carlos@gmail.com"
        val pass = "Carlos123"
        val expectedResult = true
        val validationResult = MainActivityRepositoryImpl().validateCredentials(
            LoginData(email,pass)
        )
        assertEquals(expectedResult, validationResult)
    }

    @Test
    fun validateCredentials_AddValidCredentials_FailureValidation() {
        val email = "carlos.correo.com"
        val pass = "Carlos123"
        val expectedResult = false
        val validationResult = MainActivityRepositoryImpl().validateCredentials(
            LoginData(email,pass)
        )
        assertEquals(expectedResult, validationResult)
    }
}
```
## activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="mainActivityViewModel"
            type="gracodev.android.baubaptest.ui.viewmodels.MainActivityViewModel" />
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".ui.activities.MainActivity">

        <androidx.appcompat.widget.AppCompatEditText
            android:id="@+id/editTextTextEmailAddress"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="@dimen/size_8_4"
            android:layout_marginEnd="@dimen/size_8_4"
            android:ems="10"
            android:text="@={mainActivityViewModel.onGetEmail()}"
            android:inputType="textEmailAddress"
            android:hint="@string/login_input_email_hint_text"
            android:minHeight="@dimen/size_8_6"
            app:layout_constraintBottom_toTopOf="@+id/editTextTextPassword"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_chainStyle="packed"
            tools:ignore="SpeakableTextPresentCheck"
            android:autofillHints="" />

        <androidx.appcompat.widget.AppCompatEditText
            android:id="@+id/editTextTextPassword"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginTop="@dimen/size_8_2"
            android:ems="10"
            android:text="@={mainActivityViewModel.onGetPassword()}"
            android:inputType="textPassword"
            android:hint="@string/login_input_password_hint_text"
            android:minHeight="@dimen/size_8_6"
            app:layout_constraintBottom_toTopOf="@+id/login_button"
            app:layout_constraintEnd_toEndOf="@id/editTextTextEmailAddress"
            app:layout_constraintStart_toStartOf="@id/editTextTextEmailAddress"
            app:layout_constraintTop_toBottomOf="@id/editTextTextEmailAddress"
            tools:ignore="SpeakableTextPresentCheck"
            android:autofillHints="" />

        <Button
            android:id="@+id/login_button"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="@dimen/size_8_4"
            android:layout_marginTop="@dimen/size_8_2"
            android:layout_marginEnd="@dimen/size_8_4"
            android:text="@string/login_button_text"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="@id/editTextTextPassword"
            app:layout_constraintStart_toStartOf="@id/editTextTextPassword"
            app:layout_constraintTop_toBottomOf="@id/editTextTextPassword" />
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

## License

[MIT](https://choosealicense.com/licenses/mit/)
