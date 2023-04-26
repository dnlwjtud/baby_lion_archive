const editor = new toastui.Editor({
    el: document.querySelector('#editor'),
    height: '550px',
    initialEditType: 'markdown',
    previewStyle: 'vertical'
});

function writePost(e) {

    // DOM (document)
    const headerName = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
    const tokenValue = document.querySelector("meta[name='_csrf']").getAttribute("content");

    const selectEl = document.querySelector("#category-select");
    const categoryCode = selectEl.options[selectEl.selectedIndex].value;

    console.log('categoryCode = ',categoryCode);

    if ( categoryCode === "" ) {
        alert('카테고리를 선택해주세요.');
        return;
    }


    // 제목
    const postTitle = document.querySelector("#post-title")
        .value;

    // 포스트의 내용
    const htmlBody = editor.getHTML();
    const markdownBody = editor.getMarkdown();

    const data = {
        "title" : postTitle,
        htmlBody,
        markdownBody,
        categoryCode,
    };

    fetch("http://localhost:8083/posts/write", {
        method: "POST",
        headers: {
            "Content-Type" : "application/json",
            [headerName] : tokenValue
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

