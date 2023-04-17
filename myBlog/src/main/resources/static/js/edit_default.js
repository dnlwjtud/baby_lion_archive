const editor = new toastui.Editor({
    el: document.querySelector('#editor'),
    height: '550px',
    initialEditType: 'markdown',
    previewStyle: 'vertical'
});

// 버튼을 클릭했을 때, 이벤트 라는것을 감지하여 데이터를 추출하고
// Java로 보내는 것

function writePost(e) {

    // 제목
    const postTitle = document.querySelector("#post-title")
        .value;

    // 포스트의 내용
    const htmlBody = editor.getHTML();
    const markdownBody = editor.getMarkdown();

    const data = {
        "title" : postTitle,
        htmlBody,  // "htmlBody" : htmlBody
        markdownBody
    };


    fetch("http://localhost:8083/posts/write", {
        method: "POST",
        headers: {
            "Content-Type" : "application/json"
        },
        body : JSON.stringify(data)
    })
    .then(
        (resp) => resp.json()
    )
    .then(
        (data) => {

            console.log(data); // {postId:10}

            alert("포스트 작성이 완료되었습니다.");
            // location.replace("/posts/" + data.postId);
            location.replace(`/posts/${data.postId}`);

        }
    )
    .catch(
        (err) => {
            console.log(err);
        }
    )


}

