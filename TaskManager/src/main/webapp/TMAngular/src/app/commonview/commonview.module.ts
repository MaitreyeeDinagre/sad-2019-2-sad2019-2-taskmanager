import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EpicComponent } from './epic/epic.component';
import { StoryComponent } from './story/story.component';
import { IssueComponent } from './issue/issue.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import{FormsModule} from '@angular/forms';
import { TaskComponent } from './task/task.component';

@NgModule({
  declarations: [EpicComponent, StoryComponent, IssueComponent, TaskComponent],
  imports: [
    CommonModule  , NgbModule, FormsModule
  ],
  exports: [ EpicComponent,StoryComponent, IssueComponent, TaskComponent]
})
export class CommonviewModule { }
