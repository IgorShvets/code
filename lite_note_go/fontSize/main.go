package main

import (
    "fyne.io/fyne/v2"
    "fyne.io/fyne/v2/app"
    "fyne.io/fyne/v2/theme"
    "fyne.io/fyne/v2/widget"
    "fyne.io/fyne/v2/container"
    "fyne.io/fyne/v2/canvas"
    "image/color"
    "log"
)

type customTheme struct {
    fyne.Theme
    font fyne.Resource
}

func (c customTheme) Font(style fyne.TextStyle) fyne.Resource {
    if c.font != nil {
        return c.font
    }
    return theme.DefaultTextFont()
}

func (c customTheme) TextSize() float32 {
    return 24 // Установите желаемый размер шрифта здесь
}

func (c customTheme) Color(name fyne.ThemeColorName, variant fyne.ThemeVariant) color.Color {
    if name == theme.ColorNameBackground {
        return color.RGBA{R: 240, G: 240, B: 240, A: 255}
    }
    return c.Theme.Color(name, variant)
}

func loadCustomFont(path string) fyne.Resource {
    fontRes, err := fyne.LoadResourceFromPath(path)
    if err != nil {
        log.Fatalf("Failed to load font: %v", err)
    }
    return fontRes
}

func main() {
    // Создаем новое приложение
    a := app.New()

    // Загружаем пользовательский шрифт
    customFont := loadCustomFont("C:/Users/starr/YandexDisk/coding/lite_note_go/Involve-Regular.ttf")

    // Применяем новую тему с пользовательским шрифтом
    a.Settings().SetTheme(&customTheme{theme.DefaultTheme(), customFont})

    // Создаем новое окно
    w := a.NewWindow("Custom Font Size Example")

    // Создаем виджеты с использованием canvas.Text для установки размера шрифта
    hello := canvas.NewText("Hello Fyne!", color.Black)
    hello.TextSize = 24 // Установите желаемый размер шрифта

    hello2 := canvas.NewText("Another text", color.Black)
    hello2.TextSize = 24 // Установите желаемый размер шрифта

    button := widget.NewButton("Click Me", func() {})
    entry := widget.NewEntry()
    entry.SetPlaceHolder("Type something...")

    // Устанавливаем содержимое окна
    w.SetContent(container.NewVBox(
        hello,
        hello2,
        button,
        entry,
    ))

    // Устанавливаем размер окна и показываем его
    w.Resize(fyne.NewSize(400, 300))
    w.ShowAndRun()
}
