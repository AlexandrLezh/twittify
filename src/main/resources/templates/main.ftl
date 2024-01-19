<#import "parts/common.ftl" as c>
<#import "parts/temp.ftl" as l>

<@c.page>
<div>
    <@l.logout />
    <span><a href="/user">User list</a></span>
</div>
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="text" placeholder="Input message" />
        <input type="text" name="tag" placeholder="Tag">
        <input type="file" name="file">
        <button type="submit">Add</button>
    </form>
</div>
<div>Messages list</div>
<form method="get", action="/main">
    <input type="text" name="filter" value="${filter?ifExists}">

    <button type="submit">Search</button>
</form>
<#list messages as message>
<div>
    <b>${message.id}</b>
    <span>${message.text}</span>
    <i>${message.tag}</i>
    <strong>${message.authorName}</strong>
    <div>
        <#if message.filename??>
            <img src="/img/${message.filename}">
        </#if>
    </div>
</div>
<#else>
No message
</#list>
</@c.page>