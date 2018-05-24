import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatToolbarModule, MatInputModule, 
         MatSlideToggleModule, MatCardModule, MatIconModule, 
         MatTableModule, 
         MatRadioButton,
         MatRadioModule} from '@angular/material';

@NgModule({
  imports: [MatButtonModule, MatToolbarModule, MatInputModule, MatSlideToggleModule, MatCardModule, MatIconModule, MatTableModule, MatRadioModule],
  exports: [MatButtonModule, MatToolbarModule, MatInputModule, MatSlideToggleModule, MatCardModule, MatIconModule, MatTableModule, MatRadioModule],
})
export class MaterialModule { }