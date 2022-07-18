# Using Our Github Repo
Here's a quick guide on how to use our shared [github repository](https://github.com/lyndonishere/Refund-Api)!

There are of course multiple ways to accomplish these, here are just some steps I found helpful.

## Cloning New Repository
When you need to clone a new repository, you can open your gitbash and do this command:

git clone https://github.com/lyndonishere/Refund-Api.git

It should say some stuff underneath and create a local clone of the remote github repository.

It should also create the new repository in a newly created folder

## Opening Local Repository
Open VS Code

Go to "File" on top left

Click "Open Folder..."

Select the folder that your newly cloned repository was created in

Open that folder

*NOTE: do not open File Explorer and drag and drop the folder into VS Code. This seems to make a copy of the folder within another folder and you may have to delete it all and restart if you do that.

Make sure to go to Source Control on the left hand side, click the ... next to Source Control on the very top, and select BOTH Source Control Repositories and Source Control.
    - Source Control Repositories shows you what branch you are working in
    - Source Control is how you update your branch

## Pulling from Main
You should pull from main before you start writing your code and before you push it to ensure that you're working with the most up-to-date information.

To pull, 
1. Click on the ... next to Source Control (the second Source Control)
2. Click on Pull, Push
3. Click on Pull from
4. Pull from origin
5. Pull from origin/main

Now your local repo should have the most updated information!

## Creating a New Branch
We need to work in branches so can we write code without interferring with main until our code gets approved by other groupmates.

To create a new branch,
1. Pull from main first
2. Click on the ... next to Source Control (the second Source Control)
3. Click on Branch
4. Click on Create Branch
5. Type in a Branch name (try to do your name + description. ex: oriana-acceptance-criteria)
6. Press enter to confirm
7. Voila!
8. Check you are now working in your new branch in Source Control Repositories. It should say your branch name next to the little icon

## Writing in Your New Local Branch
We will do any code writing in our newly created branch. This is ensuring your code is being written in a way that the main branch is secure.

Firstly,
1. Check you're in the right branch (Source Control Repositories)
2. Pull from main
3. Make your changes. Try to communicate with others about what you are working on beforehand and throughout

## Updating Your Remote Branch
If you're done writing locally, it's time to update your remote branch.

To update your remote branch,
1. Check you're in the right branch (Source Control Repositories)
2. Pull from main
3. In Source Control, add the Changes with the + to move them to Staged Changes. You can either do them individually by + each file or stage all new changes by using the + to the right of Changes
4. Enter a message in the input box above the Commit button. Just a message about what you did
5. Press commit
6. Press sync changes
7. There might be a pop-up asking you if you want to pull, push. Press ok
8. You may need to press sync changes again
9. Check your branch on the [github repository](https://github.com/lyndonishere/Refund-Api) to make sure the information updated. You will not see it on main yet

## Merging Your Remote Branch to the Main Branch
If you want to merge your remote branch into the main branch, you'll need to make a pull request.

1. Go to the [github repository](https://github.com/lyndonishere/Refund-Api)
2. Go to Pull Requests. It should be under Star and Watch and to the left of Code and Issues, kinda in the middle of the webpage
3. Click new or press pull changes to make a new pull request (green button)
4. Write a message and confirm you want to make the new pull request
5. Once 2 others approve, your branch will be merged with the main branch

## Approving a Pull Request
We should be as proactive with pull requests as possible so we can always be working with the most up-to-date information. 

To do so,

1. Go to the [github repository](https://github.com/lyndonishere/Refund-Api)
2. Go to Pull Requests. It should be under Star and Watch and to the left of Code and Issues, kinda in the middle of the webpage
3. Click on any new pull requests
4. Review the code. If you see any errors or have any comments, you can leave a message on the request and should contact whoever made the pull request
5. If all good, approve the request
6. Once there are 2 approvals, the branch can be merged with main
7. You can also delete that branch now if you were just using it temporarily


# There we go! That should be everything we need for Github Repos right now :) hope this helps