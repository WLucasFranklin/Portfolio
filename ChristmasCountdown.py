from bs4 import BeautifulSoup
from email.message import EmailMessage
import requests
import smtplib
import ssl
import schedule
import time

def main():
    #Get desired data and format the output.
    try:
        URL = "https://www.calendarr.com/united-states/how-many-days/christmas-day/"
        result = requests.get(URL).content
        doc = BeautifulSoup(result, "html.parser")
        data = ((doc.find(class_="day-counter--detail-text")).find("strong")).string[:-4] #Strips source content to only the number of days.
        outPut = data + "days until Christmas!"
    except:
        print("Error: Unable to gather data.")

    #Email output to end user.
    #Requires sender address, sender app password, and reciever address.
    sender = ""
    sPass = ""
    reciever = ""
    
    try:
        email = EmailMessage()
        email["Subject"] = "Christmas Countdown"
        email["From"] = sender
        email["To"] = reciever
        email.set_content(outPut)

        with smtplib.SMTP_SSL("smtp.gmail.com", 465, context=ssl.create_default_context()) as send:
                send.login(sender, sPass)
                send.sendmail(sender, reciever, email.as_string())

    except:
        print("Error: Unable to send email.")

#Schedule code to run once per week.
schedule.every().friday.at("7:00").do(main)

while True:
    schedule.run_pending()
    time.sleep(1)
