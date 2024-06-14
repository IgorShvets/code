package main 

import (
    "fyne.io/fyne/v2"
    "fyne.io/fyne/v2/app"
    "fyne.io/fyne/v2/container"
    "fyne.io/fyne/v2/widget"
)

// CustomLayout - кастомный макет для управления размером кнопок
type CustomLayout struct{}

// Layout - метод для размещения виджетов
func (c *CustomLayout) Layout(objects []fyne.CanvasObject, size fyne.Size) {
    if len(objects) != 2 {
        return
    }

    smallButton := objects[0]
    largeButton := objects[1]

    smallButton.Resize(fyne.NewSize(size.Width/8, size.Height))
    largeButton.Resize(fyne.NewSize(7*size.Width/8, size.Height))

    smallButton.Move(fyne.NewPos(0, 0))
    largeButton.Move(fyne.NewPos(size.Width/8 + 3, 0))
}

// MinSize - метод для определения минимального размера макета
func (c *CustomLayout) MinSize(objects []fyne.CanvasObject) fyne.Size {
    minWidth := float32(0)
    minHeight := float32(0)

    for _, obj := range objects {
        min := obj.MinSize()
        minWidth += min.Width
        if min.Height > minHeight {
            minHeight = min.Height
        }
    }

    return fyne.NewSize(minWidth, minHeight)
}

func main() {
    a := app.New()
    w := a.NewWindow("Custom Layout Example")

    // Создаем две кнопки
    smallButton := widget.NewButton("Small Button", func() {})
    largeButton := widget.NewButton("Large Button", func() {})

    // Создаем контейнер с кастомным макетом
    customLayout := &CustomLayout{}
    content := container.New(
        customLayout,
        smallButton,
        largeButton,
    )

    w.SetContent(content)
    w.Resize(fyne.NewSize(400, 100))
    w.ShowAndRun()
}
