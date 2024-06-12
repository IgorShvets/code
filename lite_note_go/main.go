package main

import "fyne.io/fyne/v2/app"
import "fyne.io/fyne/v2/widget"
import "fyne.io/fyne/v2/container"

func main() {
	mainApp := app.New()
	mainWindow := mainApp.NewWindow("LiteNote")

	btnFirst := widget.NewButton("First", actionBtnFirst)

	mainWindow.SetContent(container.NewVBox(
		btnFirst,
	))


	mainWindow.ShowAndRun()
}

func actionBtnFirst() {
	
}