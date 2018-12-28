package com.example.menglingshuai.weatherapp.domain.commands

interface Command<out T> {
    fun execute(): T
}