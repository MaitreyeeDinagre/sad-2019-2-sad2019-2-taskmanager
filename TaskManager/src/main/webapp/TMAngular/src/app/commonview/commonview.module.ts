import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EpicComponent } from './epic/epic.component';
import { StoryComponent } from './story/story.component';
import { IssueComponent } from './issue/issue.component';

@NgModule({
  declarations: [EpicComponent, StoryComponent, IssueComponent],
  imports: [
    CommonModule
  ]
})
export class CommonviewModule { }
