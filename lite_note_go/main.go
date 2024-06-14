package main

import (
	"fyne.io/fyne/v2"
	"fyne.io/fyne/v2/app"
	"fyne.io/fyne/v2/container"
	"fyne.io/fyne/v2/theme"
	"fyne.io/fyne/v2/widget"
)

//как я понял переопределяем методы Layout и MinSize
//и записываем их в эту структуру, потом ее скармливаем
//в content, это для поведения виджетов так, как нам надо
type MainLayout struct {}
//а это содаем тему и переопределяем FontSize чтоб
//изменить размер шрифта у всех виджетов увеличить шрифт
type customTheme struct {
	fyne.Theme
}

func (c customTheme) TextSize() float32 {
	return 40 
}

func (c *MainLayout) Layout (objects []fyne.CanvasObject, size fyne.Size){
	txtSearchNote := objects[0]

	txtSearchNote.Resize(fyne.NewSize(size.Width/10*3, size.Height/10*2))

	txtSearchNote.Move(fyne.NewPos(0,0))
}

func (c *MainLayout) MinSize (objects []fyne.CanvasObject) fyne.Size {
	minWidth := float32(0)
	minHeight := float32(0)

	for _, obj := range objects {
		min := obj.MinSize()
		minWidth += min.Width
		if min.Height > minHeight{
			minHeight = min.Height
		}
	}
	return fyne.NewSize(minWidth, minHeight)
}

func main() {
	mainApp := app.New()
	mainApp.Settings().SetTheme(&customTheme{theme.DefaultTheme()})	
	mainWindow := mainApp.NewWindow("LiteNote")

	txtSearchNote := widget.NewEntry()

	mainLayout := &MainLayout{}

	content := container.New(
		mainLayout,
		txtSearchNote,
	)

	mainWindow.SetContent(content)
	mainWindow.ShowAndRun()
}
