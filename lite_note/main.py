import tkinter as tk
import tkinter.font as tkFont



#function set option new tkinter widget
def set_widget_options(app: tk.Tk, widget, grid_col, grid_row, col_pad, row_pad):
    widget.grid(row=grid_row, column=grid_col)
    widget.grid(columnspan=col_pad, rowspan=row_pad)
    widget.grid(sticky="nsew")

    app.grid_columnconfigure(grid_col, weight=1)
    app.grid_columnconfigure(grid_row, weight=1)

def create_widgets(app: tk.Tk):
    ent_note_search_note = tk.Entry(app)
    

#create main application loop
main_app = tk.Tk()
#create font for all application
default_font = tkFont.nametofont("TkDefaultFont")
default_font.configure(size=20)
main_app.title("Lite Note")
#set default application font
main_app.option_add('*Font', default_font)

#create and config all widget
set_widget_options(main_app, ent_note_search_note, 0, 0, 5, 1)

btn_new_note = tk.Button(main_app, text="N")
set_widget_options(main_app, btn_new_note, 0, 1, 1, 1)

btn_delete_note = tk.Button(main_app, text="D")
set_widget_options(main_app, btn_delete_note, 1, 1, 1, 1)

btn_open_notes_folder = tk.Button(main_app, text="O")
set_widget_options(main_app, btn_open_notes_folder, 2, 1, 1, 1)

btn_move_note = tk.Button(main_app, text="M")
set_widget_options(main_app, btn_move_note, 3, 1, 1, 1)

btn_setting_notes = tk.Button(main_app, text="S")
set_widget_options(main_app, btn_setting_notes, 4, 1, 1, 1)

list_notes = tk.Listbox(main_app)
set_widget_options(main_app, list_notes, 0, 2, 5, 1)

main_app.mainloop()