import tkinter as tk
import tkinter.font as tkFont

ent_note_search: tk.Entry
btn_new_note: tk.Button
btn_delete_note: tk.Button
btn_move_note: tk.Button
btn_setting_notes: tk.Button
list_notes: tk.Listbox

ent_attach_search: tk.Entry
btn_new_attach: tk.Button
btn_delete_attach: tk.Button
btn_edit_attach: tk.Button
btn_move_attach: tk.Button
btn_setting_attach: tk.Button
list_attach: tk.Listbox
txt_attach: tk.Text
lbl_attach_info: tk.Label
#734
def on_resize(event):
    lbl_attach_info.config(text=f"{event.width}x{event.height}")

#function set option new tkinter widget
def set_widget_options(app: tk.Tk, widget, grid_col, grid_row, col_pad, row_pad):
    app.columnconfigure(0, weight=0)
    app.columnconfigure(1, weight=0)
    app.columnconfigure(2, weight=0)
    app.columnconfigure(3, weight=0)

    app.columnconfigure(4, weight=20)
    app.columnconfigure(5, weight=20)
    app.columnconfigure(6, weight=20)
    app.columnconfigure(7, weight=20)
    app.columnconfigure(8, weight=20)
    app.rowconfigure(5, weight=0)

    widget.grid(row=grid_row, column=grid_col)
    widget.grid(columnspan=col_pad, rowspan=row_pad)
    widget.grid(sticky="nsew")
    widget.grid(pady=1)


#create all widget in main window
def create_widgets(app: tk.Tk):
    global ent_note_search
    global btn_new_note
    global btn_delete_note
    global btn_move_note
    global btn_setting_notes
    global list_notes

    global ent_attach_search
    global btn_new_attach
    global btn_delete_attach
    global btn_move_attach
    global btn_edit_attach
    global btn_setting_attach
    global list_attach
    global txt_attach
    global lbl_attach_info

    ent_note_search = tk.Entry(app)
    btn_new_note = tk.Button(app, text="N")
    btn_delete_note = tk.Button(app, text="D")
    btn_move_note = tk.Button(app, text="M")
    btn_setting_notes = tk.Button(app, text="S")
    list_notes = tk.Listbox(app)

    ent_attach_search = tk.Entry(app)
    btn_new_attach = tk.Button(app, text="N")
    btn_delete_attach = tk.Button(app, text="D")
    btn_move_attach = tk.Button(app, text="M")
    btn_edit_attach = tk.Button(app, text="E")
    btn_setting_attach = tk.Button(app, text="S")
    list_attach = tk.Listbox(app)
    txt_attach = tk.Text(app, height=5)
    lbl_attach_info = tk.Label(app)


#create main application loop
main_app = tk.Tk()
main_app.bind("<Configure>", on_resize)
main_app.geometry("1000x600")
main_app.maxsize(width=main_app.winfo_screenwidth(), height=734)
#create font for all application
default_font = tkFont.nametofont("TkDefaultFont")
default_font.configure(size=20)
main_app.title("Lite Note")
#set default application font
main_app.option_add('*Font', default_font)

#create and config all widget
create_widgets(main_app)

set_widget_options(main_app, ent_note_search, 0, 0, 4, 1)
set_widget_options(main_app, btn_new_note, 0, 1, 1, 1)
set_widget_options(main_app, btn_delete_note, 1, 1, 1, 1)
set_widget_options(main_app, btn_move_note, 2, 1, 1, 1)
set_widget_options(main_app, btn_setting_notes, 3, 1, 1, 1)
set_widget_options(main_app, list_notes, 0, 2, 4, 7)

set_widget_options(main_app, ent_attach_search, 4, 0, 5, 1)
set_widget_options(main_app, btn_new_attach, 4, 1, 1, 1)
set_widget_options(main_app, btn_delete_attach, 5, 1, 1, 1)
set_widget_options(main_app, btn_move_attach, 6, 1, 1, 1)
set_widget_options(main_app, btn_edit_attach, 7, 1, 1, 1)
set_widget_options(main_app, btn_setting_attach, 8, 1, 1, 1)
set_widget_options(main_app, list_attach, 4, 2, 5, 3)
set_widget_options(main_app, txt_attach, 4, 5, 5, 2)
set_widget_options(main_app, lbl_attach_info, 4, 7, 5, 1)


main_app.mainloop()