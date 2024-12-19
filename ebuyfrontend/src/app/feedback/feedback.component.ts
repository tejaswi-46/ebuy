import { Component } from '@angular/core';
import { Feedback } from '../models/feedback';
import { FormsModule } from '@angular/forms';
import { FeedbackService } from '../services/feedback.service';

@Component({
  selector: 'app-feedback',
  imports: [FormsModule],
  templateUrl: './feedback.component.html',
  styleUrl: './feedback.component.css'
})
export class FeedbackComponent {
fd:Feedback=new Feedback()

constructor(private fdserv:FeedbackService)
{

}

submitdata()
{
  this.fd.email=localStorage.getItem("email")
  this.fdserv.savefeedback(this.fd).subscribe(data=>{
    if(data!=null)
    {
      alert("Thank you for valuable feedback!")
    }
  })
}


}